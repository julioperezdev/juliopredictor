package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao;

import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface RefreshTokenDao extends JpaRepository<RefreshTokenEntity, Long> {
    /*
    =============================
    String querySaveRefreshToken = "EXEC saveRefreshToken @Token = :token , @CreateDate = :createdate ";
    //            "INSERT INTO RefreshToken (token, createdDate) " +
//            "VALUES( :token , :createdDate  ) RETURNING * ;";
    @Query(value = querySaveRefreshToken, nativeQuery = true)
    RefreshTokenEntity saveRefreshToken(
            @Param("token") String token,
            @Param("createdate") Date createDate
    );

     */

    /*
    =============================
    String queryGetRefreshTokenByToken = "SELECT TOP 1 * FROM REFRESH_TOKEN WHERE token = :token ORDER BY id DESC;";
    @Query(value = queryGetRefreshTokenByToken, nativeQuery = true)
    Optional<RefreshTokenEntity> getRefreshTokenByToken(
            @Param("token") String token
    );

     */
    Optional<RefreshTokenEntity> findFirstByToken(String token);

    /*
    =============================
    String queryDeleteRefreshTokenByToken = "DELETE FROM RefreshToken WHERE token = :token ;";
    @Query(value = queryDeleteRefreshTokenByToken, nativeQuery = true)
    void deleteRefreshTokenByToken(
            @Param("token") String token
    );
     */
    void deleteByToken(String token);
    //Optional<RefreshTokenEntity> findByToken(String token);
}
