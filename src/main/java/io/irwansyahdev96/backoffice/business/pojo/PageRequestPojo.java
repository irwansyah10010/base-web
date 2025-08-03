package io.irwansyahdev96.backoffice.business.pojo;

import lombok.Data;

@Data
public class PageRequestPojo {
    private Integer draw;
    private int page;      // Halaman ke-berapa (mulai dari 0)
    private int size;      // Jumlah data per halaman
    private String sortBy; // Nama kolom sorting
    private String sortDir; // ASC atau DESC
    private String search; // Optional: keyword global
}
