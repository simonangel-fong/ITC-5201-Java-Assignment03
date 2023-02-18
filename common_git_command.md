- github repository address:
  - `https://github.com/simonangel-fong/ITC-5201-Java-Assignment03.git`



## 1. create directory

1. Create an empty directory for this assignment with any directory name.
2. Open vscode -> In vscode, open the above directory.

---

## 2. Clone github repository

- In terminal, launch a new git bash terminal. Be sure the path in git bash terminal is the above directory.

- Clone github repository to the local directory.
  - `git clone https://github.com/simonangel-fong/ITC-5201-Java-Assignment03.git .`

---

## Configuration the remote repository

- Add remote url
    - `git remote add ass03 https://github.com/simonangel-fong/ITC-5201-Java-Assignment03.git`

## 3. Create a new branch

- list branch

  - `git branch`

- creat a new branch
  - `git branch <new_branch_name>`
- Switch to the new branch
  - `git checkout <new_branch_name>`

---

## 4. add files and progam in the new branch

not git command needed this stage.

---

## 5. Commit new changes to local `git`

- When necessary work finished.

- Track all untracked files

  - `git add *`

- Commit uncommitted files
  - `git commit -m "<msg>"`
    - `<msg>`: a brief description of the commit.

---

## 6. Push the latest commit to github

- `git push ass03`

## 7. Synchronize the local files in master branch with files on github

- Switch to the master branch
  - `git checkout master`

- Pull to local
    - `git pull .`
