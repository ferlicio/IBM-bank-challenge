import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ContaCredito } from 'src/shared/models/contaCredito';

@Injectable({
  providedIn: 'root'
})
export class ContaCreditoApiService {
  readonly BASE_URL = environment.IBMBankApi.baseUrl;
  readonly ENDPOINT = environment.IBMBankApi.endpoints.contasCredito;
  readonly FULL_URL = `${this.BASE_URL}/${this.ENDPOINT}`;

  constructor(private http: HttpClient) { }

  getContaCreditoById(id: number): Observable<ContaCredito> {
    return this.http.get<ContaCredito>(`${this.FULL_URL}/${id}`);
  }

}
