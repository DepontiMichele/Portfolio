import password_tools
import validators

# password_gen handles the user interface: displays menus, collects
# user input, and coordinates calls to the other modules.

def mostra_analisi(pwd):
    # Retrieve composition, score, and label from the calculation module
    comp = password_tools.analizza_composizione(pwd)
    punteggio = password_tools.calcola_punteggio(pwd)
    etichetta, consiglio = password_tools.descrivi_punteggio(punteggio)

    # Print the password and its character-by-character breakdown
    print("-" * 30)
    print(f"Password: {pwd}")
    print("-" * 30)
    print("COMPOSIZIONE:")
    for chiave, valore in comp.items():
        # capitalize() uppercases the first letter
        # :<12 left-aligns the text within a 12-character wide field
        print(f"  {chiave.capitalize():<12}: {valore}")

    # Visual bar: each '#' represents 4 points of score
    barra = "#" * (punteggio // 4)
    print(f"\nForza: {etichetta} ({punteggio}/100)")
    print(f"[{barra:<25}]")  # :<25 keeps the bar always 25 characters wide
    print(f"Consiglio: {consiglio}\n")

def genera_con_opzioni():
    """Asks for parameters, generates the password, and offers to regenerate it."""
    # Collect user preferences once
    lunghezza = validators.leggi_intero("Lunghezza (4-64): ", minimo=4, massimo=64)
    maius = validators.leggi_conferma("Includere maiuscole? [s/n]: ")
    num = validators.leggi_conferma("Includere numeri? [s/n]: ")
    simb = validators.leggi_conferma("Includere simboli? [s/n]: ")

    # Regeneration loop: the user can request a new password
    # with the same parameters without re-entering everything
    while True:
        pwd = password_tools.genera_password(lunghezza, maius, num, simb)
        mostra_analisi(pwd)

        ancora = validators.leggi_conferma("Vuoi generare un'altra con gli stessi parametri? [s/n]: ")
        if not ancora:
            break

def menu():
    while True:
        print("\n=== GENERATORE DI PASSWORD ===")
        print("1. Genera una password")
        print("2. Valuta una password esistente")
        print("0. Esci")

        scelta = validators.leggi_scelta("Scelta: ", ["1", "2", "0"])

        if scelta == "1":
            genera_con_opzioni()

        elif scelta == "2":
            # The user enters an existing password to analyze
            pwd = validators.leggi_stringa("Inserisci la password da valutare: ")
            mostra_analisi(pwd)

        elif scelta == "0":
            print("Arrivederci!")
            break

# Entry point: menu() is called only if the file is run directly
# (not imported as a module)
if __name__ == "__main__":
    menu()
