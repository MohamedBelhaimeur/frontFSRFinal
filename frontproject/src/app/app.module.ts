import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatIconModule } from '@angular/material/icon';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';

import { AppRoutingModule } from './app-routing.module';
import { SearchComponent } from './pages/Search/search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DeleteComponent } from './pages/Delete/delete.component';
import { CreateComponent } from './pages/create/create.component';
import { UpdateComponent } from './pages/update/update.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchComponent,
    DeleteComponent,
    CreateComponent,
    UpdateComponent,
  ],
  imports: [
    BrowserModule,
    MatIconModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
  ],
  exports: [],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
