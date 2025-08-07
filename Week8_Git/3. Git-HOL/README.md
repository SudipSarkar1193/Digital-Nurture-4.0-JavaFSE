# Git Hands-On Lab 3: Branching and Merging
This assignment was all about learning the branching and merging workflow, which is one of the most powerful features of Git.

## Assignment Goal
The objective was to create a separate branch to work on a new "feature," and then merge that feature back into the main master branch once it was complete.

### Terminal 

```bash
D:\GitDemo3>git init
Initialized empty Git repository in D:/GitDemo3/.git/

D:\GitDemo3>echo "# My Project" > README.md

D:\GitDemo3>git add README.md

D:\GitDemo3>git commit -m "Initial commit"
[master (root-commit) 9b662dc] Initial commit
 1 file changed, 1 insertion(+)
 create mode 100644 README.md

D:\GitDemo3>git branch GitNewBranch

D:\GitDemo3>git checkout GitNewBranch
Switched to branch 'GitNewBranch'

D:\GitDemo3>echo "This is a new feature file." > feature.txt

D:\GitDemo3>git add feature.txt

D:\GitDemo3>git commit -m "Add feature file to new branch"
[GitNewBranch f3529f4] Add feature file to new branch
 1 file changed, 1 insertion(+)
 create mode 100644 feature.txt

D:\GitDemo3>git checkout master
Switched to branch 'master'

D:\GitDemo3>git diff GitNewBranch
diff --git a/feature.txt b/feature.txt
deleted file mode 100644
index 920e106..0000000
--- a/feature.txt
+++ /dev/null
@@ -1 +0,0 @@
-"This is a new feature file."

D:\GitDemo3>git merge GitNewBranch
Updating 9b662dc..f3529f4
Fast-forward
 feature.txt | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 feature.txt

D:\GitDemo3>git log --oneline --graph --decorate
* f3529f4 (HEAD -> master, GitNewBranch) Add feature file to new branch
* 9b662dc Initial commit

D:\GitDemo3>git branch -d GitNewBranch
Deleted branch GitNewBranch (was f3529f4).

D:\GitDemo3>git status
On branch master
nothing to commit, working tree clean

D:\GitDemo3>
```

### Screenshot 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week8_Git/3.%20Git-HOL/Screenshot/Screenshot%202025-08-08%20003047.png?raw=true)