# validators is responsible for validating user input.
# Each function handles a different input type and keeps asking
# until the user provides a valid value.

def leggi_stringa(prompt):
    """Reads a non-empty string. Loops until input is valid."""
    while True:
        valore = input(prompt).strip()  # strip() removes leading and trailing spaces
        if valore:                       # if the string is not empty, it's valid
            return valore
        print("Errore: il campo non può essere vuoto.")

def leggi_intero(prompt, minimo=None, massimo=None):
    """Reads an integer and checks the range if specified."""
    while True:
        try:
            valore = int(input(prompt))           # try to convert input to integer
            if minimo is not None and valore < minimo:
                print(f"Errore: il valore deve essere almeno {minimo}.")
            elif massimo is not None and valore > massimo:
                print(f"Errore: il valore non può superare {massimo}.")
            else:
                return valore                     # value is within the valid range
        except ValueError:
            # the user entered something that is not a number
            print("Errore: inserisci un numero intero valido.")

def leggi_conferma(prompt):
    """Reads s/n. Returns True (s) or False (n)."""
    while True:
        scelta = input(prompt).lower().strip()  # normalize to lowercase
        if scelta in ['s', 'si']:
            return True
        if scelta in ['n', 'no']:
            return False
        print("Errore: rispondi con 's' per sì o 'n' per no.")

def leggi_scelta(prompt, opzioni_valide):
    """Reads a choice from a list of valid options. Case insensitive."""
    # convert all options to lowercase for comparison
    opzioni_valide = [str(o).lower() for o in opzioni_valide]
    while True:
        scelta = input(prompt).lower().strip()
        if scelta in opzioni_valide:
            return scelta
        print(f"Errore: scelta non valida. Opzioni possibili: {', '.join(opzioni_valide)}")
