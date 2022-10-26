import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { RouterModule } from '@angular/router';
import { SearchComponent } from './pages/Search/search.component';
import { DeleteComponent } from './pages/Delete/delete.component';
import { CreateComponent } from './pages/create/create.component';
import { UpdateComponent } from './pages/update/update.component';
const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'search', component: SearchComponent },
  { path: 'update', component: UpdateComponent },
  { path: 'delete', component: DeleteComponent },
  { path: 'create', component: CreateComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)],
})
export class AppRoutingModule {}
