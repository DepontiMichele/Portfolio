import random
import string

# password_tools handles all the core logic: password generation,
# composition analysis, and strength scoring.

# --- Scoring constants ---
# Each character is worth 1 base point; bonuses are added
# if the password contains at least one character of that category.
PUNTI_PER_CARATTERE = 1
BONUS_MAIUSCOLE = 5
BONUS_NUMERI = 5
BONUS_SIMBOLI = 7

def genera_password(lunghezza, maiuscole, numeri, simboli):
    # Start with only lowercase letters in the pool
    pool_caratteri = string.ascii_lowercase
    lista_password = []

    # Guarantee at least one character per requested category,
    # so the password always meets the criteria chosen by the user.
    if maiuscole:
        lista_password.append(random.choice(string.ascii_uppercase))
        pool_caratteri += string.ascii_uppercase  # add to pool for the remaining slots

    if numeri:
        lista_password.append(random.choice(string.digits))
        pool_caratteri += string.digits

    if simboli:
        lista_password.append(random.choice(string.punctuation))
        pool_caratteri += string.punctuation

    # Fill the remaining slots by picking randomly from the full pool
    while len(lista_password) < lunghezza:
        lista_password.append(random.choice(pool_caratteri))

    # Shuffle to avoid guaranteed characters always appearing at the start
    random.shuffle(lista_password)
    return "".join(lista_password)

def analizza_composizione(password):
    # Returns a dictionary with the count of each character type
    return {
        "lunghezza": len(password),
        "maiuscole": sum(1 for c in password if c.isupper()),
        "minuscole": sum(1 for c in password if c.islower()),
        "numeri":    sum(1 for c in password if c.isdigit()),
        "simboli":   sum(1 for c in password if c in string.punctuation),
    }

def calcola_punteggio(password):
    comp = analizza_composizione(password)

    # Base score: one point per character
    punteggio = comp["lunghezza"] * PUNTI_PER_CARATTERE

    # Bonus for each category present (at least one character of that type)
    if comp["maiuscole"] > 0:
        punteggio += BONUS_MAIUSCOLE
    if comp["numeri"] > 0:
        punteggio += BONUS_NUMERI
    if comp["simboli"] > 0:
        punteggio += BONUS_SIMBOLI

    # Variety bonus: the more different categories are present, the more points.
    # "lunghezza" is excluded because it is not a character category.
    tipi_usati = sum(1 for k, v in comp.items() if k != "lunghezza" and v > 0)
    punteggio += tipi_usati * 2

    return min(punteggio, 100)  # score is capped at 100

def descrivi_punteggio(punteggio):
    # Translates the numeric score into a human-readable label and a tip
    if punteggio < 40:
        return "DEBOLE", "Prova ad aumentare la lunghezza o aggiungere simboli."
    elif punteggio < 70:
        return "MEDIA", "Aggiungere più varietà la renderebbe più sicura."
    elif punteggio < 90:
        return "FORTE", "Ottima password!"
    else:
        return "MOLTO FORTE", "Sicurezza eccellente."
