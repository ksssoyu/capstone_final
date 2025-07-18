package com.seatify.backend.api.home.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({
		"cafeId",
		"name",
		"phoneNumber",
		"address",
		"status",
		"commentReviewCount",
		"openingHours",
		"latitude",
		"longitude"
})
public interface HomeProjection {

	@Schema(description = "카페 이름", example = "5to7", required = true)
	String getName();

	@Schema(description = "카페 Id", example = "1", required = true)
	String getCafeId();

	@Schema(description = "카페 번호", example = "050713337616", required = true)
	String getPhoneNumber();

	@Schema(description = "카페 주소", example = "서울시 성동구 서울숲2길44-13 1층", required = true)
	String getAddress();

	@Schema(description = "카페 리뷰 개수", example = "10", required = true)
	String getCommentReviewCount();

	@Schema(description = "영업 상태", example = "영업중", required = true)
	String getStatus();

	@Schema(description = "운영 시간 (JSON 문자열)", example = "{\"periods\":[], \"weekdayDescriptions\":[]}", required = false)
	String getOpeningHours(); // ✅ 추가

	@Schema(description = "위도", example = "37.5460707", required = true)
	String getLatitude();

	@Schema(description = "경도", example = "127.043297", required = true)
	String getLongitude();

	void setName(String name);
	void setCafeId(String cafeId);
	void setPhoneNumber(String phoneNumber);
	void setAddress(String address);
	void setCommentReviewCount(String commentReviewCount);
	void setStatus(String status);
	void setLatitude(String latitude);
	void setLongitude(String longitude);
	void setOpeningHours(String openingHours); // ✅ 추가
}
