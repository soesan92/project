package com.mchan.video.service;

import java.util.List;

import com.mchan.util.MchanService;
import com.mchan.video.domain.Video;

/**
 * @author soe san
 *
 */
public interface VideoService extends MchanService{
	/**
	 * @param id
	 * @return Video
	 */
	public Video getById(Long id);

	/**
	 * @return List<Video>
	 */
	public List<Video> listAll();

	/**
	 * @param searchValue
	 * @return List<Video>
	 */
	public List<Video> search(String searchValue);
}
