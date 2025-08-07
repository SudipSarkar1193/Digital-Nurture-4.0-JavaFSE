# Git Hands-On Lab 2: Using .gitignore

This is my second assignment, focusing on how to use a `.gitignore` file to keep the repository clean.

## Assignment Goal

The main objective was to learn how to tell Git to ignore specific files and folders. For this lab, I had to make sure that any file with a `.log` extension would not be tracked by Git.

## Steps I Took

1.  **Created Test Files**: First, I created a sample `app.log` file in my project directory to simulate files that I wouldn't want in my repository.

2.  **Created the `.gitignore` file**: I created a new file named `.gitignore` in the root of my project.

3.  **Added Ignore Rules**: I edited the `.gitignore` file and added the following rules:
    ```
    # Ignore all .log files
    *.log
    
    ```

4.  **Verified the Status**: I ran `git status` and confirmed that Git was no longer showing the `app.log` file as "untracked". It worked!

5.  **Committed the `.gitignore` file**: Since the `.gitignore` file is an important part of the project, I staged and committed it to the repository.

---

This was a really useful exercise. Now I understand how to prevent temporary files, build outputs, and other unnecessary stuff from being accidentally committed to my projects.

### .gitignore 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/tree/main/Week8_Git/2.%20Git-HOL/Screenshot?raw=true)