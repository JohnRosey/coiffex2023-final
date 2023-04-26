// Description: Offer model
export interface Offer {
    id: number;
    name: string;
    hairdresser: string;
    grade: number;
    description: string;
    imageURL: string;
    duration: number;
    price: number;
    location: string;
}
