package com.elliumllc.landowner.repository;

import com.elliumllc.landowner.entity.LandOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LandOwnerRepo extends JpaRepository<LandOwner, Integer> {

//    @Query(
//            value = "SELECT * FROM land_owner l WHERE l.owner_id = :id",
//            nativeQuery = true
//    )
//    LandOwner findLandOwnerById(@Param("id") Integer id);

//    @Query(
//            value = "DELETE FROM land_owner l WHERE l.owner_id = :id",
//            nativeQuery = true
//    )
//    void deleteLandOwnerById(@Param("id") Integer id);

}
