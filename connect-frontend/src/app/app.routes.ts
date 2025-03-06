import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('./components/views/views.routes').then((m) => m.View_Routes),
  },
  {
    path: 'auth',
    loadChildren: () =>
      import('./auth/authentication.routes').then(
        (m) => m.Authentication_Routes
      ),
  },
];
