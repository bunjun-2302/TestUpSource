package com.example.musicbyjun.Service;

        import com.example.musicbyjun.Model.Album;
import com.example.musicbyjun.Model.BaiHat;
        import com.example.musicbyjun.Model.ChuDe;
        import com.example.musicbyjun.Model.Playlist;
import com.example.musicbyjun.Model.QuangCao;
import com.example.musicbyjun.Model.TheLoaiTrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    //tương tác server và nhận dữ liệu
    @GET("songbanner.php")
    Call<List<QuangCao>> GetDataBanner();


    @GET("playlistforcurrent.php")
    Call<List<Playlist>> GetPlaylistCurrent();

    @GET("chudevatheloaitrongngay.php")
    Call<TheLoaiTrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<BaiHat>> GetBaihatYeuthich();

    @FormUrlEncoded
    @POST("showdanhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachBaihatTheoQuangCao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("showdanhsachbaihat.php")
    Call<List<BaiHat>> GetDanhSachBaihatTheoPlaylist(@Field("idplaylist") String idplaylist);

    @GET("showdanhsachplaylist.php")
    Call<List<Playlist>> GetAllDanhsachPlaylist();

    @FormUrlEncoded
    @POST("showdanhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihatTheoTheLoai(@Field("idtheloai") String idtheloai);

    @GET("showdanhsachchude.php")
    Call<List<ChuDe>> GetAllchude();



}
