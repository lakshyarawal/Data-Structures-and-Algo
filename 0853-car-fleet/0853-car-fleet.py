class Solution:
    class Car:
        def __init__(self, position, speed, time):
            self.position = position
            self.speed = speed
            self.time = time

        def __lt__(self, other):
            return self.position < other.position
        
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(position)
        if n == 1 or n == 0:
            return n

        all_cars = [self.Car(position[i], speed[i], (target - position[i]) / speed[i]) for i in range(n)]
        all_cars.sort()

        total_fleets = 1
        cur_fleet_time = all_cars[-1].time

        for i in range(n - 2, -1, -1):
            if all_cars[i].time > cur_fleet_time:
                cur_fleet_time = all_cars[i].time
                total_fleets += 1

        return total_fleets
        