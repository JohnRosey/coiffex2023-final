import { Offer } from './models/Offer';


export const OFFERS: Offer[] = [
    {
      id: 1,
      name: 'Dégrader (Fade)',
      hairdresser: 'John Doe',
      note: 4,
      description: "A simple haircut",
      imageURL: "https://i.pinimg.com/736x/f0/c9/a1/f0c9a152ba914a13af26349ed0e04069.jpg",
      duration: 30,
      price: 35,
      localisation: 'Paris'
    },
    {
      id: 2,
      name: 'Dégrader & Barbe',
      hairdresser: 'John Doe',
      note: 4,
      description: "A long haircut",
      imageURL: "https://i.pinimg.com/736x/e4/eb/ed/e4ebed8aa8d828be0f78cc6143811de8.jpg",
      duration: 60,
      price: 40,
      localisation: 'Paris'
    },
    {
      id: 3,
      name: 'Coupe Enfants',
      hairdresser: 'John Doe',
      note: 4,
      description: "Simple haircut + beard trimming",
      imageURL: "https://sonofelicebychristine.com/wp-content/uploads/2022/05/Male-haircut-near-me-Hair-Salon-Los-Angeles-Sono-Felice-by-Christine-scaled.jpg",
      duration: 45,
      price: 28,
      localisation: 'Paris'
    },
    {
      id: 4,
      name: 'Shampoing',
      hairdresser: 'John Doe',
      note: 4,
      description: "Long haircut + beard trimming",
      imageURL: "https://www.hairdo.be/wp-content/uploads/2019/03/shampoing-homme-liege.jpg",
      duration: 75,
      price: 10,
      localisation: 'Paris'
    }
];