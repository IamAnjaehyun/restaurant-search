package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;

    public void search(String query) {
        //지역 검색
        var searchLoaclReq = new SearchLocalReq();
        searchLoaclReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLoaclReq);

        if (searchLocalRes.getTotal() > 0) {
            var item = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = item.getTitle().replaceAll("<[^>]*>", ""); //이상한 문자열 삭제 (괄호 삭제)
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            //이미지 검색
            var searchImageRes = naverClient.searchImage(searchImageReq);
            if (searchImageRes.getTotal() > 0){
            //결과를 리턴

            }
        }

    }

}
