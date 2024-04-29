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

- ANSI colors are swapped (BRIGHT looks regular, regular looks BRIGHT)
- IntelliJ's console emulator for running batch files cannot use ANSI codes correctly, but the actual Windows Command Prompt can.

### In .jar Artifact

- Some symbols appear as `?` because the Command Prompt codemap is considerably small.
- Text is greatly widened here vs. in IntelliJ.
