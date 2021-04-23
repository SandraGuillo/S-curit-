import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormulaireInscriptionComponent } from './formulaire-inscription/formulaire-inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';

//ajouter un path a chaque ajout de component(sans oublier l'import ci dessus)
const routes: Routes = [
  {path: 'inscription',component: FormulaireInscriptionComponent},//si path='' alors http://localhost:4200/ sinon si path ='test' alors http://localhost:4200/test
  {path: 'connexion',component: ConnexionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
