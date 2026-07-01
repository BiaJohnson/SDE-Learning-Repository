# System Resource and Internet Speed Monitor

## Overview

A Python program that monitors system resources (CPU count, CPU usage, RAM usage) and tests internet speed (download, upload, ping). Demonstrates integration with external libraries for real-time system diagnostics.

## Skills Demonstrated

- System resource monitoring with psutil
- Internet speed testing with speedtest-cli
- External library integration
- Formatted diagnostic output

## Tech Stack

- Python 3
- psutil, speedtest-cli, pillow

## How to Run

```bash
cd 01_python_basics/Computer_Performance
pip install psutil speedtest-cli pillow
python cpustatus.py
```

## Highlights

- Displays CPU count, usage percentage, total/available RAM
- Runs an internet speed test showing download speed, upload speed, and ping
