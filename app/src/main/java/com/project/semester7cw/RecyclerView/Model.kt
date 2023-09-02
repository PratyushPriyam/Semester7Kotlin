package com.project.semester7cw.RecyclerView

class Model(title: String?, genre: String?, year: String?) {
    private var title: String
    private var genre: String
    private var year: String



    init {
        this.title = title!!
        this.genre = genre!!
        this.year = year!!
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(name: String) {
        title = name!!
    }

    fun getGenre(): String {
        return genre
    }

    fun setGenre(gen: String) {
        genre = gen!!
    }

    fun getYear(): String {
        return year
    }

    fun setYear(y: String) {
        genre = y!!
    }
}