package com.wcc.supertrunfo.interactor

import com.wcc.supertrunfo.entities.Drivers
import com.wcc.supertrunfo.entities.Player
import com.wcc.supertrunfo.entities.Vehicle

class Card (
        val vehicle : Vehicle,
        val drivers: Drivers,
        val player: Player
) {
        val label: String = "Card ${player.name}"
        val maxVelocity = initMaxVelocity()
        val accelerationTime = initAccelerationTime()
        val passengers = initPassengers()
        val xp = initXP()


        private fun initPassengers(): Int {
            return vehicle.passengers * (1 + drivers.defensiveDriving)
        }

        private fun initAccelerationTime(): Int {
                return vehicle.accelerationTime
        }

        private fun initMaxVelocity(): Int {

            return when (vehicle.type) {
                    "car" -> carMaxVelocity()//aqui vai contas quando o tipo de veiculo for carro
                    "motorcycle" -> motocycleMaxVelocity()//aqui vai contas quando o tipo de veiculo for moto
                    else -> bikeMaxVelocity()//aqui vai contas quando o tipo de veiculo for moto
                }
        }

        private fun bikeMaxVelocity(): Int {
            return vehicle.maxAcceleration * drivers.boldness
        }

        private fun motocycleMaxVelocity(): Int {
            return 1 / vehicle.weight * vehicle.maxAcceleration

        }

        private fun carMaxVelocity(): Int {
            return if(vehicle.style == "sedã") {
                vehicle.maxAcceleration
            } else {
                vehicle.maxAcceleration + 10
            }
        }

        private fun initXP(): Int{
           return when (vehicle.type) {
                "car" -> drivers.carXP
                "motorcycle" -> drivers.motorcycleXP
                else -> drivers.bikeXP
            }
        }
}



