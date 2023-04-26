import { Offer } from "./Offer";

// Description: User model
export interface User {
    id: number;
    username: string;
    email: string;
    passwordHash: string;
    accountType: "user" | "hairdresser";
    offers: Offer[]; //Only for hairdressers
    reservations: Offer[] //Only for users
}
