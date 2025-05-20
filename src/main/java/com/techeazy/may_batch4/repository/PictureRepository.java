package com.techeazy.may_batch4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techeazy.may_batch4.entity.PictureEntity;

public interface PictureRepository extends JpaRepository<PictureEntity,Long> {
}
