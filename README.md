---

# TextGridDungeonRedux
A reboot of an old project I had. Hoping to make it new and improved here.

---
A roguelike CLI game. That's all for now. Still under heavy development, and the first one never got very far.
This will be a culmination of sorts, applying my fundamental Java skills learned in High School and college.
It's a side project I'm making for fun.

---

Note to self: the command to check how many lines of code there are with Git Bash is:
`git ls-files | grep '\.java' | xargs wc -l`

---

## Known Problems:
### In IntelliJ:

- 
- 

### In .jar Artifact

- Stairs Symbols appear as `?`
- inv command throws `IOException` for `FileWriter` not finding the `inventory.txt` file. Seems to be that the initialization of the File writer because it can't find the file I'd made.