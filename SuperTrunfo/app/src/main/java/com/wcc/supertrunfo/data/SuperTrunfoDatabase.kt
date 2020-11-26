package com.wcc.supertrunfo.data

import com.wcc.supertrunfo.entities.Drivers
import com.wcc.supertrunfo.entities.Vehicle

class SuperTrunfoDatabase {
    fun getAllVehicles(): List<Vehicle>{
        val newVehicleOne = Vehicle(
                100,
                120,
                5,
                120,
                2,
                "sedã",
                5,
                "car")
        val newVehicleTwo = Vehicle(
                50,
                60,
                2,
                10,
                0,
                "regular",
                7,
                "bike")

        val newVehicleThree = Vehicle(
                170,
                40,
                2,
                70,
                0,
                "adventure",
                6,
                "motorcycle")

        val newVehicleFour = Vehicle(
                130,
                170,
                4,
                110,
                2,
                "hatch",
                5,
                "car")

        val newVehicleFive = Vehicle(
                30,
                240,
                1,
                13,
                0,
                "regular",
                4,
                "bike")

        return listOf(newVehicleOne, newVehicleTwo, newVehicleThree, newVehicleFour, newVehicleFive )
    }

    fun getAllDrivers(): List<Drivers>{
        val newDriversOne = Drivers(
                40,
                60,
                10,
                2,
                10,
                0,
                3,
                4)

        val newDriversTwo = Drivers(
                90,
                10,
                30,
                30,
                0,
                0,
                2,
                7,
        )

        val newDriversThree = Drivers(
                50,
                30,
                80,
                3,
                7,
                15,
                6,
                2)

        return listOf(newDriversOne, newDriversTwo, newDriversThree)
    }

}