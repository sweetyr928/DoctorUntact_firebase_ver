package model;

public class Board {

    private int profile_image;//안드로이드 앱 제작시에 자신이 원하는 이미지를 프로젝트에 포함하여 그 이미지를 불러오는 것을 테스트 -> 추 후 수정
    private String nickname;
    private String title;

    public Board(int profile_image, String nickname, String title) {
        this.profile_image = profile_image;
        this.nickname = nickname;
        this.title = title;

    } //생성자

    public Board(){}

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
