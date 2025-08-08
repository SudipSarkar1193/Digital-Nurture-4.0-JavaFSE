# Git Hands-On Lab 5

This repository was created as part of my Git hands-on lab. The main goal was to learn how to push local changes to a remote repository on GitHub.

## Objective

The lab required me to synchronize my local Git repository with a remote one, effectively backing up my work and making it available online.

## Steps and Challenges

1.  I started by initializing a new local repository and adding the remote URL from GitHub.
2.  My first attempt was to `git pull` from the remote `master` branch. This failed with the error `fatal: couldn't find remote ref master`.
3.  I learned that this error happens because the remote repository on GitHub was completely empty and didn't have a `master` branch yet. You can't pull something that doesn't exist.

## The Solution

The correct process for a new project is to create the first commit locally and then **push** it to the remote. This first push creates the branch on the remote repository.

These are the commands I used to successfully complete the lab:

```bash
# First, I created a README file for the project
echo "# GitDemo5" > README.md

# Then, I added the file to staging
git add README.md

# I made my first commit, which created the master branch locally
git commit -m "Initial commit"

# Finally, I pushed my local master branch to the remote origin
# This created the master branch on GitHub and uploaded my commit
git push origin master

```

## Screenshot 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week8_Git/5.%20Git-HOL/Screenshot/Screenshot%202025-08-08%20224713.png?raw=true)


---

This was the last mandatory hands-on. 
I am truly grateful to Cognizant for the `Digital Nurture Program`.