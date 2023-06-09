package user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import channel.bean.ChannelDTO;
import channel.service.ChannelService;
import community.service.CommunityService;
import video.bean.VideoDTO;
import video.service.VideoService;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	CommunityService communityService;
	
	@Autowired
	VideoService videoService;
	
/*	@GetMapping(value="playvideo")
	public String playvideo(Model model) {
		model.addAttribute("display","");
		model.addAttribute("display3", "./video/video.jsp");
		return "index";
	}
	*/
/*	@GetMapping(value="channelForm")
	public String channelForm(Model model) {
		
		model.addAttribute("display","./channel/channelForm.jsp");
		return "index";
	}*/
	
	@GetMapping(value="boardList")
	public String boardList(/*@RequestParam int channel_id,
							HttpSession session
							, */Model model) {
		
		
//		model.addAttribute("channel_id", channel_id);
		
		model.addAttribute("display","./channel/channelForm.jsp");
		model.addAttribute("display2","../board/boardList.jsp");
		return "index";
	}
	
	@PostMapping(value = "getBoardList")
	@ResponseBody
	public List<BoardDTO> getBoardList(@RequestParam("channel_id") int channel_id){
		System.out.println("getboardlist");
		return communityService.getBoardList(channel_id);
	}
	
	@GetMapping(value = "videosearch")
	public String videosearch(@RequestParam String videotitle, Model model) {
		
		model.addAttribute("display", "");
		model.addAttribute("display5", "./search/videosearch.jsp");
		
		
		return "index";
	}
	
	@PostMapping(value = "searchVideo")
	@ResponseBody
	public List<VideoDTO> searchVideo(@RequestParam String videotitle){
		//index.js로 돌아가서 받아온 데이터를 가지고 searchvideo로 넘어가야함
		System.out.println(videotitle);
		return videoService.searchVideo(videotitle);
	}
	
	@PostMapping(value = "mainContainerVideo")
	@ResponseBody
	public List<VideoDTO> mainContainerVideo(){
		
		return videoService.mainContainerVideo();
	}
	
	@PostMapping(value = "boardDelete")
	@ResponseBody
	public void boardDelete(@RequestParam(required = true) int board_id) {
		communityService.boardDelete(board_id);
	}
	
	@PostMapping(value = "boardUpdate")
	@ResponseBody
	public void boardUpdate(@RequestParam(required = true) String board_text, @RequestParam int board_id, @RequestParam int channel_id) {
		System.out.println(board_text + " " + board_id + " " + channel_id);
		communityService.boardUpdate(board_text, board_id, channel_id);
	}
	
//	@GetMapping(value = "boardView")
//	public String boardView(@RequestParam String board_id,
//							HttpSession session,
//							Model model) {
//		int user_id = (int) session.getAttribute("user_id");
//		
//		
//		model.addAttribute("user_id", user_id);
//		model.addAttribute("board_id", board_id);
//		model.addAttribute("display","./board/contentView.jsp");
//		return "index";
//	}
	
	@GetMapping(value = "boardView")
	public String boardView(@RequestParam int board_id,
							Model model) {
		model.addAttribute("board_id", board_id);
		model.addAttribute("display","./board/contentView.jsp");
		return "index";
	}
	
	@PostMapping(value = "getBoardView")
	@ResponseBody
	public BoardDTO getBoardView(@RequestParam int board_id) {
		System.out.println(board_id);
		return communityService.getBoardView(board_id);
	}
	
	
	@PostMapping(value="channelUser_id")
	@ResponseBody
	public ChannelDTO channelUser_id(@RequestParam int user_id){
		System.out.println("dfsfd " + user_id);
		return communityService.channelUser_id(user_id);
	}
	
	@PostMapping(value = "boardWrite")
	@ResponseBody
	public void boardWrite(@RequestParam int channel_id, @RequestParam int user_id, @RequestParam(required = true) String board_text) {
		System.out.println(channel_id + " " + user_id + " " + board_text);
		communityService.boardWrite(channel_id, user_id, board_text);
	}
	
	@PostMapping(value = "getBoardCount")
	@ResponseBody
	public List<BoardDTO> getBoardCount(@RequestParam("channel_id") int channel_id, @RequestParam("user_id") int user_id){
		System.out.println("controller: channel_id : " + channel_id + "user_id : " + user_id);
		System.out.println("바보");
		return communityService.getBoardCount(channel_id, user_id);
	}
}








