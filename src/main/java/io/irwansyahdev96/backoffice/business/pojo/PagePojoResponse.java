package io.irwansyahdev96.backoffice.business.pojo;

import java.util.List;

import lombok.Data;

@Data
public class PagePojoResponse {
	private Integer draw;
	private Integer recordsFiltered;
	private Integer recordsTotal;
    private List<?> data;
}
