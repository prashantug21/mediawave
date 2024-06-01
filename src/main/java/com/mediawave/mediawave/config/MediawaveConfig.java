package com.mediawave.mediawave.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

@Configuration
public class MediawaveConfig {

    @PostConstruct
    public void init() throws IOException {
        // Using absolute path and Paths.get to handle spaces
        FileInputStream serviceAccount = new FileInputStream(Paths.get("C:/Users/prash/OneDrive/Desktop/Project/medianet assignment/mediawave/target/classes/serviceAccountKey.json").toString());

        FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

        FirebaseApp.initializeApp(options);
    }

    @Bean
    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}
