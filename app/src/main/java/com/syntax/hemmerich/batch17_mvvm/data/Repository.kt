package com.syntax.hemmerich.batch17_mvvm.data

import com.syntax.hemmerich.batch17_mvvm.data.model.Plane

class Repository {
    var planeList : List<Plane> = listOf(
        Plane(1,"Till´s Plane"),
        Plane(2,"Dave´s Plane"),
        Plane(3,"Lea´s Plane"),
        Plane(4,"Gül´s Plane"),
        Plane(5,"Cora´s Plane")
    )
}