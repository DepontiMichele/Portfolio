# 🔐 Password Generator & Analyzer

A command-line Python tool to generate secure passwords and evaluate the strength of existing ones. Built with a clean modular structure that separates logic, validation, and user interface into dedicated files.

---

## Features

- **Generate passwords** with configurable length (4–64 characters) and character sets
- **Evaluate existing passwords** with a detailed composition breakdown
- **Visual strength bar** with a score from 0 to 100
- **Strength labels**: Weak → Medium → Strong → Very Strong
- **Actionable tips** to improve password security
- **Regenerate** a new password with the same parameters without re-entering options

---

Each module has a single responsibility, making the code easy to read, test, and extend.


### Scoring System

| Component         | Points         |
|-------------------|----------------|
| Each character    | +1 per char    |
| Uppercase letters | +5 (if present)|
| Digits            | +5 (if present)|
| Symbols           | +7 (if present)|
| Variety bonus     | +2 per category used |
| **Maximum score** | **100**        |

### Strength Labels

| Score     | Label       |
|-----------|-------------|
| 0 – 39    | WEAK        |
| 40 – 69   | MEDIUM      |
| 70 – 89   | STRONG      |
| 90 – 100  | VERY STRONG |

---

## Getting Started

### Requirements

- Python 3.x
- No external libraries needed (uses only `random`, `string`)

### Run

```bash
python password_gen.py
```

### Menu Options

```
=== PASSWORD GENERATOR ===
1. Generate a password
2. Evaluate an existing password
0. Exit
```

---

## Example Output

```
------------------------------
Password: kR7#mXqL2!vT
------------------------------
COMPOSIZIONE:
  Lunghezza   : 12
  Maiuscole   : 3
  Minuscole   : 5
  Numeri      : 2
  Simboli     : 2

Forza: VERY STRONG (94/100)
[#######################  ]
Consiglio: Sicurezza eccellente.
```

---

## License
