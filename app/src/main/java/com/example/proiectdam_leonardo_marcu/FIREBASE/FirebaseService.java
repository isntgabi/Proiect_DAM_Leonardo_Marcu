package com.example.proiectdam_leonardo_marcu.FIREBASE;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proiectdam_leonardo_marcu.Clase.Badge;
import com.example.proiectdam_leonardo_marcu.Clase.Notificare;
import com.example.proiectdam_leonardo_marcu.Clase.Venit;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseService {
    private final DatabaseReference reference;

    private static FirebaseService firebaseService;

    private FirebaseService() {
        reference = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseService getInstance() {
        if(firebaseService == null) {
            synchronized (FirebaseService.class){
                if(firebaseService == null) {
                    firebaseService = new FirebaseService();
                }
            }
        }

        return firebaseService;
    }

    public void insertNotificare(Notificare notificare) {
        if (notificare == null || notificare.getId() != null) {
            return;
        }

        String id = reference.push().getKey();
        notificare.setId(id);
        reference.child(notificare.getId()).setValue(notificare);
    }

    public void insertBadge(Badge badge) {
        if (badge == null || badge.getId() != null) {
            return;
        }
        String id = reference.push().getKey();
        badge.setId(id);
        reference.child(badge.getId()).setValue(badge);

    }
    public void deleteBadge(Badge badge) {
        if (badge == null || badge.getId() == null) {
            return;
        }
        reference.child(badge.getId()).removeValue();

    }
    public void updateBadge(Badge badge) {
        if (badge == null || badge.getId() == null) {
            return;
        }

        reference.child(badge.getId()).setValue(badge);

    }

    public void updateNotificare(Notificare notificare) {
        if (notificare == null || notificare.getId() == null) {
            return;
        }

        reference.child(notificare.getId()).setValue(notificare);
    }

    public void deleteNotificare(Notificare notificare) {
        if (notificare == null || notificare.getId() == null) {
            return;
        }

        reference.child(notificare.getId()).removeValue();
    }

    public void addNotificareListener(Callback<List<Notificare>> callback) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Notificare> notificari = new ArrayList<>();
                for(DataSnapshot data : snapshot.getChildren()) {
                    Notificare notificare = data.getValue(Notificare.class);
                    if (notificare != null) {
                        notificari.add(notificare);
                    }
                }
                callback.runOnUI(notificari);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase", "Notificare indisponibila.");
            }
        });
    }

    public void addBadgeListener(Callback<List<Badge>> callback) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Badge> badges = new ArrayList<>();
                for(DataSnapshot data : snapshot.getChildren()) {
                    Badge badge = data.getValue(Badge.class);
                    if (badge != null) {
                        badges.add(badge);
                    }
                }
                callback.runOnUI(badges);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase2", "Badge indisponibil.");
            }
        });
    }
}
