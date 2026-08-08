# Course AI Rules — Installation

One rule file, read by every AI tool.

| File | Read by |
|---|---|
| `AGENTS.md` | GitHub Copilot, Cursor, Codex, Gemini CLI, and most coding agents (the single source of truth — edit rules HERE only) |
| `CLAUDE.md` | Claude Code (pointer to AGENTS.md) |
| `.junie/guidelines.md` | JetBrains Junie (pointer to AGENTS.md) |
| `.github/copilot-instructions.md` | Older GitHub Copilot setups (pointer to AGENTS.md) |
| `web-chat-prompt.txt` | ChatGPT / Claude / Gemini on the web — they cannot see repo files, so students paste this as the FIRST message of every new chat |

## How this course uses these files

1. These files live in the ROOT of the single course repository — the same
   codebase is extended across all 5 workshops.
2. At the start of each session, the instructor announces the session number
   and every student updates `CURRENT_SESSION` in `AGENTS.md` in their own
   clone (then commits it with their work). AI assistants are instructed to
   never change this number themselves.
3. The web-chat prompt is also printed in the student Prompt Cheat Sheet.

Note: rule files are guidance, not enforcement — AI follows them most of the
time, and students can delete them. Real enforcement stays with the human-side
course rules (AI Log, random "explain this line" checks, tests).
