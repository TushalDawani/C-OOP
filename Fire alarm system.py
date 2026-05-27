import random
import time

# --- Thresholds ---
TEMP_SAFE     = 30
TEMP_WARNING  = 50
SMOKE_SAFE    = 20
SMOKE_WARNING = 40

# --- Environment: generate random sensor data ---
def get_sensor_data():
    temperature = random.randint(20, 90)
    smoke_level = random.randint(0, 80)
    return temperature, smoke_level

# --- AI Reflex Agent: decide action based on percepts ---
def reflex_agent(temperature, smoke_level):
    if temperature > TEMP_WARNING or smoke_level > SMOKE_WARNING:
        return "FIRE ALARM! Evacuate immediately!"
    elif temperature > TEMP_SAFE or smoke_level > SMOKE_SAFE:
        return "WARNING: Elevated temperature or smoke detected."
    else:
        return "All clear. No threats detected."

# --- Display sensor status ---
def display_status(temp, smoke, action):
    print("-" * 45)
    print(f"  Temperature : {temp}°C")
    print(f"  Smoke Level : {smoke}%")
    print(f"  Status      : {action}")
    print("-" * 45)

# --- Main monitoring loop ---
def main():
    print("=== Fire Alarm System Started ===")
    print("Press Ctrl+C to stop.\n")
    try:
        while True:
            temp, smoke = get_sensor_data()
            action = reflex_agent(temp, smoke)
            display_status(temp, smoke, action)
            time.sleep(2)
    except KeyboardInterrupt:
        print("\nSystem stopped.")

if __name__ == "__main__":
    main()
