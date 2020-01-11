package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
  * @FileName : BestAlbum.java
  * @Project : Algorithm
  * @Date : 2020. 1. 11. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 해시 베스트앨범 문제 풀이
 */

public class BestAlbum {
	
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        String genre;
        int playcount;
        Album album;
        List<Album> list;
        List<String> genreList;
        List<Integer> bestAlbumList = new ArrayList<Integer>();
        
        HashMap<String, List<Album>> albumList = new HashMap<String, List<Album>>();
        HashMap<String, Integer> genrePlayCount = new HashMap<String, Integer>();
        
        for(int i=0; i<genres.length; i++) {
        	genre = genres[i];
        	playcount = plays[i];
        	album = new Album(genre, playcount, i);
        	
        	if(albumList.containsKey(genre)) {
        		albumList.get(genre).add(album);
        	}
        	else {
        		list = new ArrayList<Album>();
        		list.add(album);
        		albumList.put(genre, list);
        		genrePlayCount.put(genre, 0);
        	}
        	
        	genrePlayCount.put(genre, genrePlayCount.get(genre)+playcount);
        }
        
        genreList = sortByValue(genrePlayCount);
        
        for(int i=0; i<genreList.size(); i++) {
        	genre = genreList.get(i);
        	list = albumList.get(genre);
        	
        	if(list.size()==1)
        		bestAlbumList.add(list.get(0).number);
        	else {
	        	Collections.sort(list,new Comparator<Album>() {
	
					@Override
					public int compare(Album o1, Album o2) {
						if(o1.playCount==o2.playCount)
							return o1.number-o2.number;
						else
							return o2.playCount - o1.playCount;
					}
	
					
				});
	        	
	        	bestAlbumList.add(list.get(0).number);
	        	bestAlbumList.add(list.get(1).number);
        	}
        }
        
        answer = new int[bestAlbumList.size()];
        int i=0;
        for(int num : bestAlbumList) {
        	answer[i] = num;
        	i++;
        }
        
        return answer;
    }
	
	public static List sortByValue(Map<String, Integer> map) {

		List<String> list = new ArrayList<String>();

		list.addAll(map.keySet());



		Collections.sort(list,new Comparator<Object>() {

			public int compare(Object o1,Object o2) {
	
			Object v1 = map.get(o1);
	
			Object v2 = map.get(o2);
	
			return ((Comparable) v2).compareTo(v1);
	
			}

		});

//		Collections.reverse(list); // 주석시 오름차순

		return list;

		}
	
	static class Album{
		String genre;
		int playCount;
		int number;
		
		public Album(String genre, int playCount, int number) {
			this.genre = genre;
			this.playCount = playCount;
			this.number = number;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}));
	}

}
