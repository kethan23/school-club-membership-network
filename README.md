# school-club-membership-network
Automated analysis and bipartite network visualization of student-club memberships using Scala and Python.

## Network Visualization

![Student Club Network](student_club_network.png)

The visualization above shows the bipartite network of students and their club memberships. Students and clubs are represented as nodes, with edges connecting students to the clubs they belong to.

### Retrieving the Visualization

#### Manual Retrieval
1. Navigate to the repository's main page
2. Locate the `student_club_network.png` file
3. Download or view the image directly

#### Automated Retrieval
You can download the visualization programmatically using:

```bash
# Using wget
wget https://raw.githubusercontent.com/kethan23/school-club-membership-network/main/student_club_network.png

# Using curl
curl -O https://raw.githubusercontent.com/kethan23/school-club-membership-network/main/student_club_network.png
```

Or in Python:

```python
import urllib.request

url = 'https://raw.githubusercontent.com/kethan23/school-club-membership-network/main/student_club_network.png'
urllib.request.urlretrieve(url, 'student_club_network.png')
```
