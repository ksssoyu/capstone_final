package com.seatify.backend.domain.review.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seatify.backend.api.member.dto.MemberReviewProjection;
import com.seatify.backend.domain.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	@Query(value = "SELECT "
		+ "c.name AS 'cafeName', "
		+ "CONCAT(c.address) AS 'address', "
		+ "r.cafe_congestion AS 'cafeCongestion', "
		+ "r.is_clean AS 'isClean', "
		+ "r.has_plug AS 'hasPlug' "
		+ "FROM review r "
		+ "LEFT JOIN "
		+ "cafe c ON c.cafe_id = r.cafe_id "
		+ "WHERE r.member_id = :memberId ", nativeQuery = true)
	List<MemberReviewProjection> findReviewsByMemberId(@Param("memberId") Long memberId);

	@Query(value = "SELECT "
		+ "r.cafe_id "
		+ "FROM review r "
		+ "WHERE r.member_id = :memberId "
		+ "AND r.created_time > DATE_SUB(NOW(), INTERVAL 1 DAY) ", nativeQuery = true)
	List<Long> findCafeIdsOfRecentReviews(@Param("memberId") Long memberId);

	@Query("select count(r) from Review r where r.member.memberId = :memberId")
	long countReviewByMemberId(@Param("memberId") Long memberId);

	@Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Review r WHERE r.cafe.cafeId = :cafeId")
	Boolean existsReviewByCafeId(@Param("cafeId") Long cafeId);
}
