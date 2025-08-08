# Git Hands-On Lab: Merge Conflict Resolution

This repository contains the work I completed for the Git hands-on lab focused on resolving merge conflicts.

## Objective

The main goal of this hands-on lab was to learn how to handle and resolve a merge conflict in Git. 

This situation occurs when one user updates the main branch (master) in a way that conflicts with modifications made in a feature branch[cite: 4].

## Commands 

```bash
PS D:\GitDemo4> git init
Initialized empty Git repository in D:/GitDemo4/.git/
PS D:\GitDemo4> echo "<message>Content from master branch</message>" > hello.xml
PS D:\GitDemo4> git add hello.xml
PS D:\GitDemo4> git commit -m "Initial commit on master"
[master (root-commit) 5afd963] Initial commit on master
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 hello.xml
PS D:\GitDemo4> git checkout -b GitWork
Switched to a new branch 'GitWork'
PS D:\GitDemo4> echo "<message>Updated content in GitWork</message>" > hello.xml
PS D:\GitDemo4> git add hello.xml
PS D:\GitDemo4> git commit -m "Updated hello.xml in GitWork branch"
[GitWork 31c98b1] Updated hello.xml in GitWork branch
 1 file changed, 0 insertions(+), 0 deletions(-)
PS D:\GitDemo4> git checkout master
Switched to branch 'master'
PS D:\GitDemo4> echo "<message>A conflicting update from master</message>" > hello.xml
PS D:\GitDemo4> git add hello.xml
PS D:\GitDemo4> git commit -m "Conflicting update on master"
[master e4b4047] Conflicting update on master
 1 file changed, 0 insertions(+), 0 deletions(-)
PS D:\GitDemo4> git merge GitWork
warning: Cannot merge binary files: hello.xml (HEAD vs. GitWork)
Auto-merging hello.xml
CONFLICT (content): Merge conflict in hello.xml
Automatic merge failed; fix conflicts and then commit the result.
PS D:\GitDemo4> cat hello.xml
<message>A conflicting update from master</message>
PS D:\GitDemo4> echo "<message>Final resolved content</message>" > hello.xml
PS D:\GitDemo4> git add hello.xml
PS D:\GitDemo4> git commit -m "Resolved merge conflict"
[master 58372da] Resolved merge conflict
PS D:\GitDemo4> git branch -d GitWork
Deleted branch GitWork (was 31c98b1).
PS D:\GitDemo4> git log --oneline --graph --decorate
*   58372da (HEAD -> master) Resolved merge conflict
|\
| * 31c98b1 Updated hello.xml in GitWork branch
* | e4b4047 Conflicting update on master
|/
* 5afd963 Initial commit on master
PS D:\GitDemo4>
```

### Final Result 

The final commit history graph shows the successful merge. This proves that the two separate lines of work were combined back into the master branch.

```bash

* 58372da (HEAD -> master) Resolved merge conflict  <-- The final merge
|\
| * 31c98b1 Updated hello.xml in GitWork branch <-- The commit from GitWork
* | e4b4047 Conflicting update on master      <-- The commit from master
|/
* 5afd963 Initial commit on master            <--The common ancestor

```

## Screenshot of the Terminal 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week8_Git/4.%20Git-HOL/Screenshot/Terminal_Screenshot.png?raw=true)