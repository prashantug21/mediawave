package com.mediawave.mediawave.service;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mediawave.mediawave.model.Student;



@Service
public class MediawaveService {


    public String createrStudent(Student student) throws InterruptedException, ExecutionException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collecApiFuture=dbFirestore.collection("students").document(student.getId()).set(student);
        return collecApiFuture.get().getUpdateTime().toString();
    }

    public List<Student> getAllStudents() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference students = dbFirestore.collection("students");
        ApiFuture<QuerySnapshot> querySnapshot = students.get();

        List<Student> studentList = new ArrayList<>();
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            Student student = document.toObject(Student.class);
            studentList.add(student);
        }
        return studentList;
    }

    public Student getStudentById(String studentid) throws InterruptedException, ExecutionException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        DocumentReference documentReference= dbFirestore.collection("students").document(studentid);
        ApiFuture<DocumentSnapshot> future= documentReference.get();
        DocumentSnapshot document= future.get();
        Student student;
        if(document.exists()){
            // return "Found";
            System.out.println("Document data: " + document.getData());
            student=document.toObject(Student.class);
            return student;
        }
        return null;
    }

    public String updateStudent(Student student) throws InterruptedException, ExecutionException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        DocumentReference documentReference= dbFirestore.collection("students").document(student.getId());
        ApiFuture<DocumentSnapshot> future= documentReference.get();
        DocumentSnapshot document= future.get();
        if(document.exists()){
            ApiFuture<WriteResult> collecApiFuture=dbFirestore.collection("students").document(student.getId()).set(student);
            return collecApiFuture.get().getUpdateTime().toString();
        }
        return "Student doesn't Exist";
        
    }

    public String deleteStudent(String studentid) throws InterruptedException, ExecutionException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        DocumentReference documentReference= dbFirestore.collection("students").document(studentid);
        ApiFuture<DocumentSnapshot> future= documentReference.get();
        DocumentSnapshot document= future.get();
        if(document.exists()){
            ApiFuture<WriteResult> collecApiFuture=dbFirestore.collection("students").document(studentid).delete();
            return "Deleted Successfully";
        }
        return "Student doesn't Exist";

    }
    
}
