import java.util.*;
public class Album {
    private String name,artist;
    private SongList songs;
    public class SongList{
        private  ArrayList<Song> songs;
        public SongList(){
            songs=new ArrayList<>();
        }
        private boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }
            songs.add(song);
            return true;
        }
        private Song findSong(String titleOfSong){
            for(int i=0;i<songs.size();i++){
                if(songs.get(i).getTitle().equals(titleOfSong)){
                    return songs.get(i);
                }
            }
            return null;
        }
        private Song findSong(int trackNumberOfSong){
            return songs.get(trackNumberOfSong-1);
        }

    }
    public Album(String name,String artist){
        this.name=name;
        this.artist=artist;
        songs=new SongList();

    }

    public boolean addSong(String titleOfSong,double durationOfSong){
        if(titleOfSong==null||durationOfSong<0){
            return false;
        }
        songs.add(new Song(titleOfSong,durationOfSong));
        return true;
    }
    public boolean addToPlayList(int trackNumberOfSongInAlbum,LinkedList playList){
        if(songs.findSong(trackNumberOfSongInAlbum)==null||trackNumberOfSongInAlbum<0
                ||trackNumberOfSongInAlbum>=songs.songs.size()){
            return false;
        }
        playList.add(songs.findSong(trackNumberOfSongInAlbum));
        return true;
    }
    public boolean addToPlayList(String titleOfSong,LinkedList playList){
        if(songs.findSong(titleOfSong)==null||titleOfSong==null){
            return false;
        }
        playList.add(songs.findSong(titleOfSong));
        return true;
    }

}
