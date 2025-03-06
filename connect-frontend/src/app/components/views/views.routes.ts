import { HomeComponent } from './home/home.component';
import { ImageComponent } from './image/image.component';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './settings/settings.component';
import { TextComponent } from './text/text.component';
import { VideoComponent } from './video/video.component';
import { Routes } from '@angular/router';

export const View_Routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'text', component: TextComponent },
  { path: 'photo', component: ImageComponent },
  { path: 'video', component: VideoComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'settings', component: SettingsComponent },
];
