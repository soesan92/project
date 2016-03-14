package com.mchan.video.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.video.domain.Video;
/**
 * @author soe san
 *
 */
@Service("videoService")
@Transactional(propagation = Propagation.REQUIRED)
public class VideoServiceImpl implements VideoService{

	@SuppressWarnings("javadoc")
	@Autowired
	private VideoService videoService;

	public void insert(Object obj) {
		videoService.insert(obj);
	}

	public void update(Object obj) {
		videoService.update(obj);
	}

	public void delete(Long id) {
		videoService.delete(id);
	}

	public Video getById(Long id) {
		return videoService.getById(id);
	}

	public List<Video> listAll() {
		return videoService.listAll();
	}

	public List<Video> search(String searchValue) {
		return videoService.search(searchValue);
	}

}
