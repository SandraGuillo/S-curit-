export class PasswordDTO {
  public password : string
  public sel : string;

  constructor(){

  }


}

export class Password {
  public id: number;
  public password: string;
  public passwordHashe: string;
  public passwordHasheEtSale: string;
  public passwordHasheEtSaleUtilisateur: string;
  public passwordChiffre: string;

  constructor() {
  }
}
