package com.techeazy.may_batch4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@Getter
@Setter
public class PictureModel {

	private Integer Id;

	private String filePath;

	private String location;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy HH:MM:SS")
	private LocalDateTime date;



}
