package com.example.moviesapp.repository

import com.example.moviesapp.model.Movie

class MovieRepository {

    fun getMovie() = Movie(
        title = "Avengers: Endgame последние нормальные",
        storyLine = """After the devastating events of Avengers: Infinity War, the universe is in ruins. 
            |With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' 
            |actions and restore balance to the universe. Ыыыфаызфоазо ап ызщвоп джлиедп удмлжц мкужмукж кжу 
            |м уклмд кту кдулжмт к
            | улдмткуж мц мкуджмктудждж цумку отмцдж ажфо мцакждомт цдмт кжЫыыфаызфоазо ап ызщвоп джлиедп удмлжц мкужмукж кжу 
            |м уклмд кту кдулжмт к
            | улдмткуж мц мкуджмктудждж цумку отмцдж ажфо мцакждомт цдмт кжЫыыфаызфоазо ап ызщвоп джлиедп удмлжц мкужмукж кжу 
            |м уклмд кту кдулжмт к
            | улдмткуж мц мкуджмктудждж цумку отмцдж ажфо мцакждомт цдмт кж""".trimMargin()
    )
}