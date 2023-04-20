// Description: Offer model
export interface Offer {
    id: number;
    name: string;
    hairdresser: string;
    note: number;
    description: string;
    imageURL: string;
    duration: number;
    price: number;
    localisation: string;
}
