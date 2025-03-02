package com.Project.AI.stock_image.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
	private final OpenAiImageModel imageModel;

	public ImageService(OpenAiImageModel imageModel) {
		this.imageModel = imageModel;
	}
	
	public ImageResponse generateImage(String prompt, String qualtiy, int n, int width, int height) {
		//this is normal response without any configuration for our images
		//ImageResponse imageResponse = imageModel.call(new ImagePrompt(prompt));
				
//		ImageResponse imageResponse = imageModel.call(
//		        new ImagePrompt(prompt,
//		        OpenAiImageOptions.builder()
//		        		.withModel("dall-e-2")
//		                .quality("hd")
//		                .N(4) //this specify how much images will be generated
//		                .height(1024)
//		                .width(1024).build())
//
//		);
		
		ImageResponse imageResponse = imageModel.call(
		        new ImagePrompt(prompt,
		        OpenAiImageOptions.builder()
		        		.withModel("dall-e-2")
		                .quality(qualtiy)
		                .N(n) //this specify how much images will be generated
		                .height(height)
		                .width(width).build())

		);
		
		return imageResponse;
	}
}
