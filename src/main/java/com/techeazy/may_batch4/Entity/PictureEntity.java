package com.techeazy.may_batch4.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pictures")
public class PictureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filePath", nullable = false)
    private String filePath;

    @Column(name = "location")
    private String location;

    @Column(name = "UploadedAt")
    private LocalDateTime date;



}
